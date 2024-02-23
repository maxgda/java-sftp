# Local SFTP Server for Testing

This documentation guides you through setting up a simple SFTP server implemented using the Apache Mina SSHD library, Java, and Spring Boot. This server is designed for testing.

## Starting the Server

To start the server, you can either run the [SftpServerApplication.java](src%2Fmain%2Fjava%2Fat%2Fsecure%2Fftp%2FSftpServerApplication.java) class from your IDE or use the following commands from the command line:

```bash
mvn clean install
mvn spring-boot:run
```

## Testing SFTP Session

Execute the following command to test the SFTP session. The password is 'password'.

```bash
sftp -oPort=2222 foo@localhost
```

The first time you run this command, it will prompt you to add the host key to your local `~/.ssh/known_hosts` file. You can now retrieve the saved host key from your `known_hosts` file for use.

Example prompt:

```plaintext
The authenticity of host '[localhost]:2222 ([::1]:2222)' can't be established.
RSA key fingerprint is SHA256:0lUTPTgivp12WiWr/6O+9BEiU1sAkzCneIlAnTNntU4.
Are you sure you want to continue connecting (yes/no)?
```

## Additional Resources

For more detailed information on how this SFTP server is implemented, you can refer to the following articles:

1. [How to Implement an SFTP Server in Java Spring Boot using Apache Mina SSHD](https://programmingtechie.com/2019/02/23/how-to-implement-an-sftp-server-in-java-spring-boot-using-apache-mina-sshd/)
2. [How to Implement an SFTP Server in Java Spring Boot using Apache Mina SSHD - Part 2: Using Public Key Authentication](https://programmingtechie.com/2019/08/18/how-to-implement-an-sftp-server-in-java-spring-boot-using-apache-mina-sshd-part-2-using-public-key-authentication/)