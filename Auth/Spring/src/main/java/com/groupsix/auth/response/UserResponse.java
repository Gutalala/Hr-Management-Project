package com.groupsix.auth.response;

import com.groupsix.auth.bean.User;
import com.groupsix.auth.common.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private ResponseStatus status;
    private User user;
}
