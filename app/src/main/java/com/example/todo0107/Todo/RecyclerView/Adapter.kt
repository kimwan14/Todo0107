package com.example.todo0107.Todo.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo0107.Todo.TodoData.TodoTable
import com.example.todo0107.databinding.HolderBinding

class Adapter: RecyclerView.Adapter<Adapter.holder>() {

    private var todoList = listOf<TodoTable>()

    class holder (val binding: HolderBinding) : RecyclerView.ViewHolder(binding.root)

    //어떤 xml로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val binding = HolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return holder(binding)
    }

    //뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: holder, position: Int) {
        val cur = todoList[position]
        holder.binding.title.text = cur.title
    }

    //뷰 홀더 개수 리턴
    override fun getItemCount(): Int {
        return this.todoList.size
    }

    fun setTodoList(dataList: List<TodoTable>){
        this.todoList = dataList
        notifyDataSetChanged()
    }
}

