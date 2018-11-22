package com.spdata.crm.role.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class RoleInput {
    private Integer RoleId;
    private List<Integer> MenuId;
    private List<Integer> PermissionId;
}
