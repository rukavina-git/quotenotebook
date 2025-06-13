package com.ikr.quotenotebook.repository

import com.ikr.quotenotebook.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>
