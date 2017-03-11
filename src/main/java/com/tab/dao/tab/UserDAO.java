package com.tab.dao.tab;

import com.tab.model.User;
import com.tab.model.UserData;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@DAO
public interface UserDAO {

    /**
     * private int id;
     * private int userID;
     * private String name; //真实姓名
     * private String nickName; //使用抹茶用户名
     * private String phone; //电话号码
     * private String postCode; //邮编
     * private int six; //性别 1：男 0：女
     * private String address; //详细住址
     * private int applyNum; //申请中的市调商品数
     * private Date birthday; //生日
     * private int bodySkin; //身体肌肤
     * private String city; //居住城市
     * private String email; //邮件地址
     * private int emailPublic; //是否公开邮件 1：是 0：否
     * private int hairSkin; //发质
     * private int faceSkin; //脸部肌肤
     * private int wholeSkin; //整体肤质
     * private String faceDescribe; //脸部肌肤描述
     * private int fileLevel;//报告等级
     * private int fileNum; //报告数量
     * private int fileScore; //报告总分
     * private int getApplyNum; //获取申请的市调商品数
     * private int married; //是否结婚 1：是  0：否
     * private int haveChildren;//是否有子女 1:是 0：否
     * private int height; //身高cm
     * private int weight; //g
     * private int job; //工作ID
     * private int lastFileStat; //最后回文状态  1:OK
     * private Date lastFileUpdateTime; //最后回文时间
     * private Date lastJoinTime; //最后获取参与市调时间
     * private int voteNum; //投票总数
     * private int status; //账号状态 1:ok 0:异常
     * private String remark; //备注
     * private Date createTime; //创建时间
     */

    String USER_DATA_PARAM = "ID,UserID,Name,NickName,Phone,PostCode,Six,Address," +
            "ApplyNum,Birthday,BodySkin,City,Email,EmailPublic,HairSkin,FaceSkin,WholeSkin," +
            "FaceDescribe,FileLevel,FileNum,FileScore,GetApplyNum,Married,HaveChildren,Height,Weight," +
            "Job,LastFileStat,LastFileUpdateTime,LastJoinTime,VoteNum,Status,Remark,CreateTime";

    /**
     * 添加用户
     *
     * @param user
     */
    @SQL("INSERT INTO USER " +
            "(MochaUserID,MochaUserName,MochaUserPic,TabUserName,TabPassWord,CreateTime) " +
            "VALUES (:1.mochaID,:1.mochaUserName,:1.mochaUserPic,:1.tabUserName,:1.tabPassWord,NOW());")
    void add(User user);

    /**
     * 添加用户数据
     *
     * @param userData
     */
    @SQL("INSERT INTO user_data " +
            "(UserID,NAME,NickName," +
            "Phone,PostCode,Six,Address,Birthday," +
            "BodySkin,City,Email,EmailPublic,HairSkin," +
            "FaceSkin,WholeSkin," +
            "FaceDescribe,Married,HaveChildren," +
            "Height,Weight,Job," +
            "LastFileUpdateTime,LastJoinTime,Remark,CreateTime) " +
            "VALUES " +
            "(:1.userID,:1.name,:1.nickName,:1.phone,:1.postCode,:1.six," +
            ":1.address,:1.birthday,:1.bodySkin,:1.city,:1.email,:1.emailPublic," +
            ":1.hairSkin,:1.faceSkin,:1.wholeSkin,:1.faceDescribe,:1.married," +
            ":1.haveChildren,:1.height,:1.weight,:1.job,:1.lastFileUpdateTime,:1.lastJoinTime,:1.remark,:1.createTime)")
    void addUserData(UserData userData);

    /**
     * 根据ID获取用户信息
     *
     * @param userId
     * @return
     */
    @SQL("SELECT " + USER_DATA_PARAM + " FROM user_data WHERE UserID = :1")
    UserData getUserDataByUserID(int userId);

    /**
     * 校验MochauserID是否存在
     *
     * @param id
     * @return
     */
    @SQL("SELECT ID FROM USER WHERE MochauserID = :1 LIMIT 1")
    Integer getIDBymochaUserID(int id);

    /**
     * 校验TabUserName是否存在
     *
     * @param username
     * @return
     */
    @SQL("SELECT ID FROM USER WHERE TabUserName = :1 LIMIT 1")
    Integer getIDByTabUserName(String username);

    /**
     * 获取用户列表
     *
     * @return
     */
    @SQL("SELECT ID,MochaUserID as mochaID,MochaUserName,MochaUserPic,TabUserName,TabPassWord,CreateTime FROM USER")
    List<User> getUserList();

    /**
     * 根据ID删除用户
     *
     * @param id
     */
    @SQL("DELETE FROM USER WHERE ID = :1")
    void deleteByID(int id);

    /**
     * 根据用户名密码获取用户ID
     *
     * @param username
     * @param password
     * @return
     */
    @SQL("SELECT ID FROM USER WHERE TabUserName = :1 AND TabPassWord = :2 LIMIT 1")
    Integer getByUsernameAndPassword(String username, String password);

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    @SQL("SELECT ID,MochaUserID as mochaID,MochaUserName,MochaUserPic,TabUserName,TabPassWord,CreateTime FROM USER WHERE ID = :1")
    User getByID(int id);

    /**
     * 更新用户数据
     *
     * @param userData
     */
    @SQL("UPDATE user_data " +
            "SET " +
            "Phone = :1.phone," +
            "PostCode = :1.postCode," +
            "Six = :1.six," +
            "Address = :1.address," +
            "Birthday = :1.birthday," +
            "BodySkin = :1.bodySkin," +
            "City = :1.city," +
            "Email = :1.email," +
            "EmailPublic = :1.emailPublic," +
            "HairSkin = :1.hairSkin," +
            "FaceSkin = :1.faceSkin," +
            "WholeSkin = :1.wholeSkin," +
            "FaceDescribe = :1.faceDescribe," +
            "WholeSkin = :1.wholeSkin," +
            "FaceDescribe = :1.faceDescribe," +
            "Married = :1.married," +
            "HaveChildren = :1.haveChildren," +
            "Height = :1.height," +
            "Weight = :1.weight," +
            "Job = :1.job," +
            "Remark = :1.remark WHERE UserID = :1.userID")
    void updateUserDate(UserData userData);
}
