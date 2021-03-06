package com.acmedcare.framework.newim.master.core;

import com.acmedcare.framework.newim.master.MasterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.acmedcare.framework.newim.MasterLogger.startLog;

/**
 * Acceptor Bootstrap
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 15/11/2018.
 */
@Configuration
public class MasterAutoBootstrap {

  private final MasterConfig masterConfig;

  @Autowired
  public MasterAutoBootstrap(MasterConfig masterConfig) {
    this.masterConfig = masterConfig;
    startLog.info("master config properties: {}", this.masterConfig);
  }

  @Bean
  public MasterClusterAcceptorServer server() {
    return new MasterClusterAcceptorServer(masterConfig);
  }
}
