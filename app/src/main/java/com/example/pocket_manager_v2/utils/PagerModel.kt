package com.example.pocket_manager_v2.utils

import com.example.pocket_manager_v2.R

enum class PagerModel
    private constructor(val titleResId : Int, val layoutResId : Int){
    TRANSACTION(R.string.string_transactions, R.layout.fragment_transaction),
    OVERVIEW(R.string.string_overview, R.layout.fragment_overview)
}