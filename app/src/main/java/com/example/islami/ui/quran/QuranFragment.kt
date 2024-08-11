package com.example.islami.ui.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.chapterdetails.ChapterDetailsActivity

class QuranFragment : Fragment() {

    var chaptersTitles = listOf(
        "سورة الفاتحة",
        "سورة البقرة",
        "سورة آل عمران",
        "سورة النساء",
        "سورة المائدة",
        "سورة الأنعام",
        "سورة الأعراف",
        "سورة الأنفال",
        "سورة التوبة",
        "سورة يونس",
        "سورة هود",
        "سورة يوسف",
        "سورة الرعد",
        "سورة إبراهيم",
        "سورة الحجر",
        "سورة النحل",
        "سورة الإسراء",
        "سورة الكهف",
        "سورة مريم",
        "سورة طه",
        "سورة الأنبياء",
        "سورة الحج",
        "سورة المؤمنون",
        "سورة النور",
        "سورة الفرقان",
        "سورة الشعراء",
        "سورة النمل",
        "سورة القصص",
        "سورة العنكبوت",
        "سورة الروم",
        "سورة لقمان",
        "سورة السجدة",
        "سورة الأحزاب",
        "سورة سبأ",
        "سورة فاطر",
        "سورة يس",
        "سورة الصافات",
        "سورة ص",
        "سورة الزمر",
        "سورة غافر",
        "سورة فصلت",
        "سورة الشورى",
        "سورة الزخرف",
        "سورة الدخان",
        "سورة الجاثية",
        "سورة الأحقاف",
        "سورة محمد",
        "سورة الفتح",
        "سورة الحجرات",
        "سورة ق",
        "سورة الذاريات",
        "سورة الطور",
        "سورة النجم",
        "سورة القمر",
        "سورة الرحمن",
        "سورة الواقعة",
        "سورة الحديد",
        "سورة المجادلة",
        "سورة الحشر",
        "سورة الممتحنة",
        "سورة الصف",
        "سورة الجمعة",
        "سورة المنافقون",
        "سورة التغابن",
        "سورة الطلاق",
        "سورة التحريم",
        "سورة الملك",
        "سورة القلم",
        "سورة الحاقة",
        "سورة المعارج",
        "سورة نوح",
        "سورة الجن",
        "سورة المزمل",
        "سورة المدثر",
        "سورة القيامة",
        "سورة الإنسان",
        "سورة المرسلات",
        "سورة النبأ",
        "سورة النازعات",
        "سورة عبس",
        "سورة الانفطار",
        "سورة المطففين",
        "سورة الانشقاق",
        "سورة البروج",
        "سورة الطارق",
        "سورة الأعلى",
        "سورة الغاشية",
        "سورة الفجر",
        "سورة البلد",
        "سورة الشمس",
        "سورة الليل",
        "سورة الضحى",
        "سورة الشرح",
        "سورة التين",
        "سورة العلق",
        "سورة القدر",
        "سورة البينة",
        "سورة الزلزلة",
        "سورة العاديات",
        "سورة القارعة",
        "سورة التكاثر",
        "سورة العصر",
        "سورة الهمزة",
        "سورة الفيل",
        "سورة قريش",
        "سورة الماعون",
        "سورة الكوثر",
        "سورة الكافرون ",
        "سورة النصر",
        "سورة المسد",
        "سورة الإخلاص",
        "سورة الفلق",
        "سورة الناس"
    )

    lateinit var binding: FragmentQuranBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    val chaptersadapter = ChapterRecyclerAdapter(chaptersTitles)

    private fun initViews(view: View) {
        binding.chaptersRecycler.adapter = chaptersadapter
        chaptersadapter.onItemClickListener =
            ChapterRecyclerAdapter.OnItemClickListener { position, title ->
                startChapterDetailsActivity(position, title)
            }
    }

    private fun startChapterDetailsActivity(position: Int, title: String) {
        val intent = Intent(activity, ChapterDetailsActivity::class.java)
        intent.putExtra(ChapterDetailsActivity.EXTRA_POSITION, position)
        intent.putExtra(ChapterDetailsActivity.EXTRA_TITLE, title)
        startActivity(intent)
    }
}