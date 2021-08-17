package com.example.diggieservice.repository

import com.example.rdiandroiddevelopertest.api.DigieServiceInterface
import javax.inject.Inject

class TeknisiRepository
@Inject constructor(
    private val digieServiceInterface: DigieServiceInterface)
{
    fun getTechnicianAll(param: String, order: String) = digieServiceInterface.getTechnician(param,order)
}