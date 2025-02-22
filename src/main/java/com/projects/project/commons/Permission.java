package com.projects.project.commons;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    CAN_READ_POST("can:read-post"),
    CAN_EDIT_POST("can:edit-post"),
    CAN_DELETE_POST("can:delete-post"),
    CAN_ADD_POST("can:delete-post");

    @Getter
    public final String permission;
}
