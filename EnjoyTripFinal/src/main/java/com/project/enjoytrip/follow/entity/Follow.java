package com.project.enjoytrip.follow.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder  
@NoArgsConstructor
@Getter
@Setter
@Table(
		uniqueConstraints = @UniqueConstraint(columnNames = {"user_id_from", "user_id_to"})
		)
@IdClass(Follow.PK.class)
public class Follow {
	@Id
    @Column(name = "user_id_from", insertable = false, updatable = false)
    private int userIdFrom;

    @Id
    @Column(name = "user_id_to", insertable = false, updatable = false)
    private int userIdTo;

    public Follow(int userIdFrom, int userIdTo) {
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
    }

    public static class PK implements Serializable {
    	/**
		 * 
		 */
		private static final long serialVersionUID = -290190465632171213L;
		int userIdFrom;
    	int userIdTo;
    }
}
