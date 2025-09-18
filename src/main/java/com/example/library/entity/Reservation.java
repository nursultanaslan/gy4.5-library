package com.example.library.entity;

import com.example.library.entity.enums.ReservationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;
    @Column(name = "expire_at")
    private LocalDateTime expireAt;

    @Enumerated(EnumType.STRING)
    private ReservationStatus resStatus;

    @ManyToOne()
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    public ReservationStatus getResStatus() {
        return resStatus;
    }

    public void setResStatus(ReservationStatus resStatus) {
        this.resStatus = resStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}