package com2027.housinghub.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 *
 */
public class GroupHelper implements Parcelable {
    private String groupId;
    private StudentAccount groupAdmin;
    private List<StudentAccount> members;

    public GroupHelper(){

    }

    /**
     *
     * @param groupAdmin
     * @param members
     */
    public GroupHelper(StudentAccount groupAdmin, List<StudentAccount> members){
        this.groupAdmin = groupAdmin;
        this.members = members;
        //groupid
    }

    protected GroupHelper(Parcel in) {
        groupId = in.readString();
        groupAdmin = in.readParcelable(StudentAccount.class.getClassLoader());
        members = in.createTypedArrayList(StudentAccount.CREATOR);
    }

    public static final Creator<GroupHelper> CREATOR = new Creator<GroupHelper>() {
        @Override
        public GroupHelper createFromParcel(Parcel in) {
            return new GroupHelper(in);
        }

        @Override
        public GroupHelper[] newArray(int size) {
            return new GroupHelper[size];
        }
    };

    public StudentAccount getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(StudentAccount groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public List<StudentAccount> getMembers() {
        return members;
    }

    public void setMembers(List<StudentAccount> members) {
        this.members = members;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(groupId);
        parcel.writeParcelable(groupAdmin, i);
        parcel.writeTypedList(members);
    }
}
