/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import model.UserBean;

/**
 *
 * @author ica
 */
public interface UserLogic {

    int validateUser(UserBean bean);

    boolean addUser(UserBean bean);

    boolean changePassword(UserBean bean);

    boolean deleteUser(UserBean bean);

    boolean updateStatus(UserBean bean);
}
