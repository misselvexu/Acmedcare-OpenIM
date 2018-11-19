package com.acmedcare.framework.newim.server;

import com.acmedcare.framework.newim.server.config.IMProperties;
import com.acmedcare.framework.newim.server.core.IMSession;
import com.acmedcare.framework.newim.server.core.NewIMServerBootstrap;
import com.acmedcare.framework.newim.server.core.connector.ClusterReplicaConnector;
import com.acmedcare.framework.newim.server.core.connector.MasterConnector;
import com.acmedcare.framework.newim.server.service.MessageService;
import com.acmedcare.framework.newim.server.service.RemotingAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cluster Server Auto Startup Configuration
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 19/11/2018.
 */
@Configuration
public class ClusterServerAutoBootstrap {

  @Bean
  public IMSession imSession() {
    return new IMSession();
  }

  @Bean
  public NewIMServerBootstrap mainServer(
      IMProperties imProperties,
      RemotingAuthService remotingAuthService,
      MessageService messageService,
      IMSession imSession) {
    return new NewIMServerBootstrap(imProperties, remotingAuthService, messageService, imSession);
  }

  @Bean
  public ClusterReplicaConnector clusterReplicaConnector(IMProperties imProperties) {
    return new ClusterReplicaConnector(imProperties);
  }

  @Bean
  public MasterConnector masterConnector(IMProperties imProperties, IMSession imSession) {
    return new MasterConnector(imProperties, imSession);
  }
}
