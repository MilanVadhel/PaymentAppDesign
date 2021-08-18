package com.example.paymentappdesign.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


@Suppress("UNCHECKED_CAST")
abstract class BaseDataBindingAdapter<I, IB : ViewDataBinding>(val callback: (I) -> Unit = {}) :
    RecyclerView.Adapter<BaseDataBindingAdapter.BaseDataBindingViewHolder>() {


    private var _items = mutableListOf<I>()

    var items: List<I> = _items
        private set


    protected abstract val layoutId: Int


    final override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseDataBindingViewHolder {
        return BaseDataBindingViewHolder(
            DataBindingUtil.inflate<IB>(
                LayoutInflater.from(parent.context), layoutId, parent, false
            )
        )
    }


    fun setItems(itemList: MutableList<I>, clearPreviousItems: Boolean = false) {
        this._items.apply {
            if (clearPreviousItems) {
                clear()
            }
            addAll(itemList)
            notifyDataSetChanged()
        }
    }


    fun addItemAt(position: Int, item: I) {
        if (position != -1) {
            this._items.add(position, item)
            notifyItemInserted(position)
        }
    }


    fun removeItemAt(position: Int) {
        if (position != -1) {
            this._items.removeAt(position)
            notifyItemRemoved(position)
        }
    }


    fun updateItemAt(position: Int, item: I) {
        if (position != -1) {
            _items[position] = item
            notifyItemChanged(position)
        }
    }


    fun getItemAt(position: Int): I {
        return items[position]
    }


    fun clearAdapter() {
        _items.clear()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return _items.size
    }


    final override fun onBindViewHolder(holder: BaseDataBindingViewHolder, position: Int) {
        onBindViewHolder(_items[position], holder.itemBinding as IB)
        holder.itemBinding.executePendingBindings()
    }


    protected abstract fun onBindViewHolder(item: I, itemBinding: IB)


    open class BaseDataBindingViewHolder(open val itemBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}