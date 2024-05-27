package com.webspace.image_utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Directory {
    ROOT("../frontend/public"),
    BACKEND("/backend_img"),
    NEWS("/news/"),
    TEAM("/team/"),
    PORTFOLIO("/portfolio/"),
    READY_MADES("/ready_mades/");
    private final String directoryName;
}

