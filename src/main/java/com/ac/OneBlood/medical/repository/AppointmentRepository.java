package com.ac.OneBlood.medical.repository;

import com.ac.OneBlood.medical.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.appointmentDateAndHour = :appointmentDateAndHour")
    List<Appointment> findByDoctorAndAppointmentDate(@Param("doctorId") Long doctorId, @Param("appointmentDateAndHour") LocalDateTime appointmentDateAndHour);

}
