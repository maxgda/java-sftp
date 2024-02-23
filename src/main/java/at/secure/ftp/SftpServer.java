/*
 * Copyright 2022 Bloomreach
 */
package at.secure.ftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.sftp.server.SftpSubsystemFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

@Service
public class SftpServer {

    private final Log log = LogFactory.getLog(SftpServer.class);

    private final SftpProperties sftpProperties;

    public SftpServer(SftpProperties sftpProperties) {
        this.sftpProperties = sftpProperties;
    }

    @PostConstruct
    public void startServer() throws IOException {
        start();
    }

    private void start() throws IOException {
        final SshServer sshd = SshServer.setUpDefaultServer();
        sshd.setHost(sftpProperties.getHost());
        sshd.setPort(sftpProperties.getPort());
        // this will create a host private key in a file called as host.ser
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(new File("host.ser").toPath()));
        sshd.setSubsystemFactories(Collections.singletonList(new SftpSubsystemFactory()));
        sshd.setPasswordAuthenticator((username, password, session) -> username.equals("foo") && password.equals("password"));
//        TODO implementation without username/password
//        sshd.setPublickeyAuthenticator(new AuthorizedKeysAuthenticator(new File("authorized_keys")));
        sshd.start();

        log.info("SFTP server started on " + sshd.getHost() + ":" + sshd.getPort());
    }
}
