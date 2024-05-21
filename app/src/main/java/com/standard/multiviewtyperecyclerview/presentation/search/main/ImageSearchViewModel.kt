package com.standard.multiviewtyperecyclerview.presentation.search.main

import androidx.lifecycle.ViewModel

class ImageSearchViewModel : ViewModel() {
    //sharedFlow -> Flow 는 콜드 스트림, collect해야 데이터를 받을 수 있음, shahredFlow -> hot Flow -> 여러 view가 구독할 수 있는 구조
    //queryFlow -> 검색어 마지막 입력값을 받기 위한 작업
    //viewModelScope : 뷰모델 라이프사이클에 맞춰줌 -> cachedIng : 쿼리 결과를 뷰모델 스코프 안에 캐싱 해두겠다
    
}