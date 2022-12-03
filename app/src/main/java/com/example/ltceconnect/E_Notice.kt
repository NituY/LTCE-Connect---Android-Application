package com.example.ltceconnect

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.SearchView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ltceconnect.NoticeAdapter.notesAdapter
import com.example.ltceconnect.NoticeDatabase.noteDatabase
import com.example.ltceconnect.NoticeModel.Note
import com.example.ltceconnect.NoticeModel.NoteViewModel
import com.example.ltceconnect.databinding.ActivityEnoticeBinding

class E_Notice : AppCompatActivity() ,notesAdapter.NotesClickListener ,PopupMenu.OnMenuItemClickListener{

    private lateinit var binding: ActivityEnoticeBinding
    private lateinit var database: noteDatabase
    lateinit var viewModel: NoteViewModel
    lateinit var adapter: notesAdapter
    lateinit var slectedNote: Note



    private val updateNote = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val note = result.data?.getSerializableExtra("note") as? Note
                if (note != null) {
                    viewModel.updateNote(note)
                }
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEnoticeBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //Initialzing
        initUI()

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)
        viewModel.allnotes.observe(this) { list ->
            list?.let {
                adapter.updateList(list)
            }

        }

        database = noteDatabase.getnoteDatabase(this)


    }

    private fun initUI() {

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        adapter = notesAdapter(this, this)
        binding.recyclerView.adapter = adapter

        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val note = result.data?.getSerializableExtra("note") as? Note
                    if (note != null) {
                        viewModel.insertNote(note)
                    }
                }


            }

        binding.fbAddNote.setOnClickListener {
            val intent = Intent(this, AddNote::class.java)
            getContent.launch(intent)

        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    adapter.filterList(newText)
                }
                return true

            }
        })

    }

    override fun onItemClicked(note: Note) {
        val intent = Intent(this@E_Notice, AddNote::class.java)
        intent.putExtra("current_note", note)
        updateNote.launch(intent)
    }

    override fun onLongItemClicked(note: Note, cardView: CardView) {
        slectedNote = note
        popUpDisplay(cardView)
    }

    private fun popUpDisplay(cardView: CardView) {
        val popup = PopupMenu(this, cardView)
        popup.setOnMenuItemClickListener(this@E_Notice)
        popup.inflate(R.menu.pop_up_menu)
        popup.show()

    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.deleteText){
            viewModel.deleteNote(slectedNote)
            return true
        }
        return false
    }
}





