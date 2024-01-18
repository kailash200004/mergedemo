 package com.jci.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciuserrole", schema = "dbo")
public class UserRoleModel {
              
              @Id
              @GeneratedValue(strategy =GenerationType.IDENTITY )
              private int role_Id;
              
              private String role_name;

              private String user_type;

              private String created_date;
              
              private String role_type;

              public int getRole_Id() {
                             return role_Id;
              }

              public void setRole_Id(int role_Id) {
                             this.role_Id = role_Id;
              }

              public String getRole_name() {
                             return role_name;
              }

              public void setRole_name(String role_name) {
                             this.role_name = role_name;
              }

              public String getUser_type() {
                             return user_type;
              }

              public void setUser_type(String user_type) {
                             this.user_type = user_type;
              }

              public String getCreated_date() {
                             return created_date;
              }

              public void setCreated_date(String created_date) {
                             this.created_date = created_date;
              }


              public String getRole_type() {
                             return role_type;
              }

              public void setRole_type(String role_type) {
                             this.role_type = role_type;
              }

              
              
              public UserRoleModel(int role_Id, String role_name, String user_type, String created_date, String role_type) {
                             //super();
                             this.role_Id = role_Id;
                             this.role_name = role_name;
                             this.user_type = user_type;
                             this.created_date = created_date;
                             this.role_type = role_type;
              }
              
              @Override
              public String toString() {
                             return "UserRoleModel [role_Id=" + role_Id + ", role_name=" + role_name + ", user_type=" + user_type
                                                          + ", created_date=" + created_date + ", role_type=" + role_type + "]";
              }

              public UserRoleModel() {
                             // TODO Auto-generated constructor stub
              }

              

}
