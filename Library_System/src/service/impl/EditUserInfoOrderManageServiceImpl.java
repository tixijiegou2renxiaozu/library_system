package service.impl;

import service.EditUserInfoOrderManageService;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户修改基本信息的方法
 */
public class EditUserInfoOrderManageServiceImpl implements EditUserInfoOrderManageService {

    public static EditUserInfoOrderManageService editUserInfoOrderManageService=new EditUserInfoOrderManageServiceImpl();

    public static EditUserInfoOrderManageService getInstance(){
        return editUserInfoOrderManageService;
    }

    @Override
    public void changePassAndChangeTableEdituserinfoorder(String id, String prePass, String laterPass) {

    }
}