package com.standard.multiviewtyperecyclerview.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.standard.multiviewtyperecyclerview.data.Card
import com.standard.multiviewtyperecyclerview.databinding.ItemBlueCardBinding
import com.standard.multiviewtyperecyclerview.databinding.ItemLightBlueCardBinding
import com.standard.multiviewtyperecyclerview.databinding.ItemOrangeCardBinding
import java.lang.IllegalArgumentException

//클릭 이벤트 처리 람다함수 파라메터로 사용
class MultiCardAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var cardList = listOf<Card>()

    //viewholder 생성
    //ViewHolder에 연결된 view 생성, 초기화
    //multi view type 처리
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //multi view type을 구현하는 item layout 연결
        return when (viewType) {
            MultiViewEnum.BLUE.viewType -> {
                val binding =
                    ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueTypeViewHolder(binding)
            }

            MultiViewEnum.LIGHTBLUE.viewType -> {
                val binding =
                    ItemLightBlueCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                LightBlueTypeViewHolder(binding)
            }

            MultiViewEnum.ORANGE.viewType -> {
                val binding =
                    ItemOrangeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                OrangeTypeViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    //viewHolder와 data 바인딩
    //클릭 이벤트 처리
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cardList[position]
        when (holder.itemViewType) {
            MultiViewEnum.BLUE.viewType -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightBlueHolder = holder as LightBlueTypeViewHolder
                lightBlueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            MultiViewEnum.ORANGE.viewType -> {
                val orangeHolder = holder as OrangeTypeViewHolder
                orangeHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    //아이템의 위치(position)에 따라 어떤 뷰 타입을 가져야하는지 결정
    //position 즉 아이템의 위치에 접근하여 아이템의 뷰타입 결정
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> MultiViewEnum.BLUE.viewType
            1 -> MultiViewEnum.LIGHTBLUE.viewType
            2 -> MultiViewEnum.ORANGE.viewType
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    //item layout의 ui값 뿌려주기
    class BlueTypeViewHolder(private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    class LightBlueTypeViewHolder(private val binding: ItemLightBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    class OrangeTypeViewHolder(private val binding: ItemOrangeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.cardType
                tvCardPeriod.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }
}