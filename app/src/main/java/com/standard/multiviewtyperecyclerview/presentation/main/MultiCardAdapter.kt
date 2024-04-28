package com.standard.multiviewtyperecyclerview.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.standard.multiviewtyperecyclerview.databinding.ItemBlueCardBinding
import com.standard.multiviewtyperecyclerview.databinding.ItemLightBlueCardBinding
import com.standard.multiviewtyperecyclerview.databinding.ItemOrangeCardBinding
import com.standard.multiviewtyperecyclerview.databinding.UnknownItemBinding
import com.standard.multiviewtyperecyclerview.presentation.model.BlueCardModel
import java.lang.IllegalArgumentException

//클릭 이벤트 처리 람다함수 파라메터로 사용
class MultiCardAdapter(private val onClick: (BlueCardModel) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var cardList = listOf<BlueCardModel>()

    //TODO
    //viewholder 생성
    //ViewHolder에 연결된 view 생성, 초기화
    //multi view type 처리
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //multi view type을 구현하는 item layout 연결
        //enum ordinal값 사용 보단 enum의 entries(enum의 list를 뽑아서 return)를 뽑아서 사용
        //sealed class
        val MuiltiViewType = MultiViewEnum.entries.find { it.viewType == viewType }
        return when (MuiltiViewType) {
            MultiViewEnum.BLUE -> {
                val binding =
                    ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueTypeViewHolder(binding)
            }

            MultiViewEnum.LIGHTBLUE -> {
                val binding =
                    ItemLightBlueCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                LightBlueTypeViewHolder(binding)
            }

            MultiViewEnum.ORANGE -> {
                val binding =
                    ItemOrangeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                OrangeTypeViewHolder(binding)
            }

            else -> {
                val binding =
                    UnknownItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                UnknownViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    //viewHolder와 data 바인딩
    //클릭 이벤트 처리
    //TODO
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cardList[position]
        when (holder) {
            is BlueTypeViewHolder -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            is LightBlueTypeViewHolder -> {
                val lightBlueHolder = holder as LightBlueTypeViewHolder
                lightBlueHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }

            is OrangeTypeViewHolder -> {
                val orangeHolder = holder as OrangeTypeViewHolder
                orangeHolder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }

    //TODO
    //아이템의 위치(position)에 따라 어떤 뷰 타입을 가져야하는지 결정
    //position 즉 아이템의 위치에 접근하여 아이템의 뷰타입 결정
    override fun getItemViewType(position: Int): Int {
        return cardList[position].cardViewType.viewType
    }

    //item layout의 ui값 뿌려주기
    class BlueTypeViewHolder(private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: BlueCardModel) {
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
        fun bind(card: BlueCardModel) {
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
        fun bind(card: BlueCardModel) {
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

    //TODO
    //Enum외의 data가 왔을 때(server or android 개발자) 대응
    class UnknownViewHolder(
        binding: UnknownItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = Unit
    }
}