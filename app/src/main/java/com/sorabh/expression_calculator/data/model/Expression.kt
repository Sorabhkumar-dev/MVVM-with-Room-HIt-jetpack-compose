package com.sorabh.expression_calculator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "expression_history")
data class Expression(@PrimaryKey(autoGenerate = true)val expressionId:Long,val expression:String,val result:String,val date:LocalDateTime = LocalDateTime.now())
