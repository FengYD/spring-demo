package com.feng.demo.es7;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * @author fengyadong
 * @date 2022/8/8 11:42
 * @Description
 */
@Data
@Document(indexName = "area")
public class AreaIndex {

    @Id
    private Long id;
    @Field(type = FieldType.Long)
    private Long pid;
    @Field(type = FieldType.Keyword)
    private String shortName;
    @Field(type = FieldType.Keyword)
    private String name;
    @Field(type = FieldType.Integer)
    private Integer level;
    @Field(type = FieldType.Keyword)
    private String pinYin;
    @Field(type = FieldType.Keyword)
    private String code;
    @Field(type = FieldType.Integer)
    private String zipCode;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String mergerName;
    @Field(type = FieldType.Keyword)
    private String first;
    @Field(type = FieldType.Double)
    private String lng;
    @Field(type = FieldType.Double)
    private String lat;
    @Field(type = FieldType.Date)
    private String createTime;
    @Field(type = FieldType.Date)
    private String updateTime;

}
