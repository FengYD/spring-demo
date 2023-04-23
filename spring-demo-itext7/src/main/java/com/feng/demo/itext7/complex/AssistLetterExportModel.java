package com.feng.demo.itext7.complex;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author fengyadong
 * @date 2023/4/23 16:42
 * @Description 导出数据 model
 */
@Data
public class AssistLetterExportModel {

    private String sendManDeptName;

    private String assistLetterNo;

    private String assistPlatEntityName;

    private String assistReason;

    private String assistScopeName;

    private List<KVData> assistProvideDataVO;

    private String assistLimit;

    private String sendUserName;

    private String sendUserPhone;

    private String sendTime;

    private List<AssistPlatScopeVO> assistReplyDataVO;

    @Data
    @AllArgsConstructor
    public static class KVData {
        private String key;
        private String value;
    }

    @Data
    @AllArgsConstructor
    public static class AssistPlatScopeVO {
        private String assistScopeId;
        private String assistScopeName;
        private List<AssistPlatReplyVO> assistPlatReplyVOList;
    }

    @Data
    @AllArgsConstructor
    public static class AssistPlatReplyVO {
        private String assistReplyId;
        private String assistReplyType;
        private String assistReplyName;
    }

}
