package com.nick.springcloud.upload.uploaddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author weizhong
 * @date 2020/6/16 10:34 PM
 * @package com.nick.springcloud.upload.uploaddemo.dto
 * @description
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse {

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

}
