package Maswillaeng.MSLback.dto.chat.response;

import lombok.Getter;


@Getter
public class SocketStatus {
    private int status;

    private String message;

    public SocketStatus(int status, String error) {
        this.status = status;
        this.message = error;
    }
}
