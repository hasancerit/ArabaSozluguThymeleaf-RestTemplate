package com.example.ArabaSozluguTh.ArabaSozluguTh.service;

import java.util.List;

import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.RequestDTO.user.UserReqDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.ArabaSozluguTh.ArabaSozluguTh.dto.ResponseDTO.user.UserResDTO;

public interface UserService {

	UserResDTO signup(SingupUserReqDTO user);

	JWTUserResDTO login(LoginUserReqDTO user);

	UserResDTO getUser(String id);

	List<UserResDTO> getAllUsers();

	UserResDTO deleteUser(String id);

	UserResDTO updateUser(UserReqDTO user, String id);

	UserResDTO findUserByPost(String postId);

}
