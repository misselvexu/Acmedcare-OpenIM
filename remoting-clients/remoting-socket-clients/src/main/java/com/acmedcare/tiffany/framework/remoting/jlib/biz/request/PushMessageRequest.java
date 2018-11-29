package com.acmedcare.tiffany.framework.remoting.jlib.biz.request;

import com.acmedcare.tiffany.framework.remoting.jlib.biz.MessageAttribute;
import com.acmedcare.tiffany.framework.remoting.jlib.biz.bean.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Push Message Request
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version v1.0 - 10/08/2018.
 */
@Getter
@Setter
@NoArgsConstructor
public class PushMessageRequest extends BaseRequest {

  private String messageType;

  private Message message;

  @Builder
  public PushMessageRequest(
      String username,
      String passportId,
      String messageType,
      Message message,
      MessageAttribute attribute) {

    super(username);
    this.messageType = messageType;
    this.setPassportId(passportId);
    this.message = message;

    this.setAttribute(attribute);
  }

  public interface Callback {
    void onSuccess(long messageId);

    void onFailed(int code, String message);
  }
}