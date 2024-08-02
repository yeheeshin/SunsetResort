package com.resort.Sunset.dto;

import com.resort.Sunset.dto.enumType.role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class admin_user {
    private Long au_id;

    private String name;
    private String admin_id;
    private String pwd;
    private role role;
}
