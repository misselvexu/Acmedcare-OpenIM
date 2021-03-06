package com.acmedcare.framework.newim.protocol.request;

import com.acmedcare.tiffany.framework.remoting.CommandCustomHeader;
import com.acmedcare.tiffany.framework.remoting.exception.RemotingCommandException;
import lombok.Getter;
import lombok.Setter;

/**
 * Master Replica Sync Session Request Header
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 14/11/2018.
 */
@Getter
@Setter
public class ClusterPushSessionDataHeader implements CommandCustomHeader {

  /** Cluster 数据版本 */
  private int dataVersion;

  @Override
  public void checkFields() throws RemotingCommandException {}
}
