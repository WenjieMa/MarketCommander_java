package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordCommentReply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_comment_reply", catalog = "marketcommander")

public class RecordCommentReply implements java.io.Serializable {

    // Fields

    private Long id;
    private Long assistantid;
    private String text;
    private Timestamp createdate;

    // Constructors

    /**
     * default constructor
     */
    public RecordCommentReply() {
    }

    /**
     * full constructor
     */
    public RecordCommentReply(Long assistantid, String text, Timestamp createdate) {
        this.assistantid = assistantid;
        this.text = text;
        this.createdate = createdate;
    }

    // Property accessors
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "assistantid")

    public Long getAssistantid() {
        return this.assistantid;
    }

    public void setAssistantid(Long assistantid) {
        this.assistantid = assistantid;
    }

    @Column(name = "text")

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "createdate", length = 19)

    public Timestamp getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

}