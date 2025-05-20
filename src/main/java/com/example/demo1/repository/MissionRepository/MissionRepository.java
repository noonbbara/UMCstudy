package com.example.demo1.repository.MissionRepository;

import com.example.demo1.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
