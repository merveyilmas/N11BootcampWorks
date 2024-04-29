package com.merveyilmaz.userservice.controller.concract.impl;

import com.merveyilmaz.userservice.controller.concract.UserControllerContract;
import com.merveyilmaz.userservice.dto.UserDTO;
import com.merveyilmaz.userservice.entitiy.User;
import com.merveyilmaz.userservice.mapper.UserMapper;
import com.merveyilmaz.userservice.request.UserSaveRequest;
import com.merveyilmaz.userservice.service.serviceEntity.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserControllerContractImpl implements UserControllerContract {

    private final UserEntityService userEntityService;

    @Override
    public UserDTO save(UserSaveRequest request) {
        User user = UserMapper.INSTANCE.convertToUser(request);

        user = userEntityService.save(user);

        return UserMapper.INSTANCE.convertToUserDTO(user);
    }
}
