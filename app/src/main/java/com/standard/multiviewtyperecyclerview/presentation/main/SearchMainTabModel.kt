package com.standard.multiviewtyperecyclerview.presentation.main

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

data class SearchMainTabModel(val fragment: Fragment,
                              @StringRes val title: Int)