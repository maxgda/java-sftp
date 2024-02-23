package at.secure.ftp;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource({"classpath:application.properties"})
@Data
@ToString
public class SftpProperties {
    private String host;
    private int port;
}
