package com.spdata.crm.role.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class RoleInput {
    private Integer RoleId;
    private List<Integer> MenuId = new ArrayList<>();
    private List<Integer> PermissionId = new ArrayList<>();
}
