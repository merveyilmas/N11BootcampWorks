package com.merveyilmaz.userservice.controller.concract;

import com.merveyilmaz.userservice.dto.UserDTO;
import com.merveyilmaz.userservice.request.UserSaveRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface UserControllerContract {

    UserDTO save(UserSaveRequest request);
}
