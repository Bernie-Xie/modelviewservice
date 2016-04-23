package com.inno.modelview.model;

import javax.persistence.*;

@Entity
@Table(name="MV_CONTRIBUTOR")
public class Contributor {

    public Contributor(String createUserName, String lastModifiedUserName) {
        CreateUserName = createUserName;
        LastModifiedUserName = lastModifiedUserName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    private String CreateUserName;
    private String LastModifiedUserName;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COREENTITY_ID", nullable = false)
    private CoreEntity owner;

    public String getCreateUserName() {
        return CreateUserName;
    }

    public void setCreateUserName(String createUserName) {
        CreateUserName = createUserName;
    }

    public String getLastModifiedUserName() {
        return LastModifiedUserName;
    }

    public void setLastModifiedUserName(String lastModifiedUserName) {
        LastModifiedUserName = lastModifiedUserName;
    }
}
