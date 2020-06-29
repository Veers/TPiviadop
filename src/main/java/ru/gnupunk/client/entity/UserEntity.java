package ru.gnupunk.client.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="users")
@NamedQueries({
        @NamedQuery(name="UserEntity.findByEmail",
                query="SELECT u FROM UserEntity u WHERE u.email = :email"),
})
public class UserEntity {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        @Basic
        @Column(name="EMAIL", length=250, nullable=false)
        private String email;

        @Basic
        @Column(name="PASSWORD", length=250, nullable=false)
        private String password;

        @Basic
        @Column(name="NAME", length = 250, nullable = false)
        private String name;

        @Basic
        @CreationTimestamp
        @Column(name = "CREATE_DATE", nullable = false)
        private Date createDate;

        @Basic
        @UpdateTimestamp
        @Column(name = "EDIT_DATE", nullable = false)
        private Date editDate;

        @Basic
        @Column(name = "ARCHIVE", nullable = false)
        private boolean archive;

        @Basic
        @Column(name = "ACTIVE", nullable = false)
        private boolean active;

        public UserEntity() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public boolean isArchive() {
                return archive;
        }

        public void setArchive(boolean archive) {
                this.archive = archive;
        }

        public boolean isActive() {
                return active;
        }

        public void setActive(boolean active) {
                this.active = active;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                UserEntity that = (UserEntity) o;
                return Objects.equals(email, that.email) &&
                        Objects.equals(password, that.password) &&
                        Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
                return Objects.hash(email, password, name);
        }

        @Override
        public String toString() {
                return "UserEntity{" +
                        "id=" + id +
                        ", email='" + email + '\'' +
                        ", password=" + password +
                        ", name='" + name + '\'' +
                        ", createDate=" + createDate +
                        ", editDate=" + editDate +
                        ", archive=" + archive +
                        ", active=" + active +
                        '}';
        }

}
