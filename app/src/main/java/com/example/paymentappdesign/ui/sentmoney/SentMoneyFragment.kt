package com.example.paymentappdesign.ui.sentmoney

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.CreditCard
import com.example.paymentappdesign.data.Transaction
import com.example.paymentappdesign.data.TransactionDue
import com.example.paymentappdesign.databinding.FragmentSentMoneyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class SentMoneyFragment : Fragment() {

    private var _binding: FragmentSentMoneyBinding? = null
    private val binding get() = _binding!!

    private val creditCardAdapter by lazy {
        CreditCardAdapter()
    }

    private val transactionDueAdapter by lazy {
        TransactionDueAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSentMoneyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initTabLayout()
        initRecyclerView()
    }

    private fun initViewPager() {
        binding.vpCards.adapter = creditCardAdapter
        creditCardAdapter.setItems(getCreditCards(), true)
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        binding.vpCards.setPageTransformer(compositePageTransformer)
        binding.vpCards.offscreenPageLimit = 3
        binding.vpCards.setCurrentItem(1, false)
    }

    private fun initTabLayout() {
        binding.tblTransactionHistory.addTab(
            binding.tblTransactionHistory.newTab().setText(R.string.sent)
        )
        binding.tblTransactionHistory.addTab(
            binding.tblTransactionHistory.newTab().setText(R.string.received)
        )
    }

    private fun initRecyclerView() {
        binding.rvTransactionDues.adapter = transactionDueAdapter
        transactionDueAdapter.setItems(getTransactionDues(), true)
    }

    private fun getCreditCards(): ArrayList<CreditCard> {
        return ArrayList<CreditCard>().apply {
            add(
                CreditCard(
                    getString(R.string.credit_card_number1),
                    getString(R.string.credit_card_holder_name1),
                    getString(R.string.credit_card_expiry_date1),
                    R.drawable.bg_card_green
                )
            )
            add(
                CreditCard(
                    getString(R.string.credit_card_number2),
                    getString(R.string.credit_card_holder_name2),
                    getString(R.string.credit_card_expiry_date2),
                    R.drawable.bg_card_purple
                )
            )
            add(
                CreditCard(
                    getString(R.string.credit_card_number3),
                    getString(R.string.credit_card_holder_name3),
                    getString(R.string.credit_card_expiry_date3),
                    R.drawable.bg_card_orange
                )
            )
        }
    }

    private fun getTransactionDues(): ArrayList<TransactionDue> {
        val todaysTransaction = ArrayList<Transaction>().apply {
            add(Transaction(profileImage = "https://cdn.pixabay.com/photo/2018/03/12/12/32/woman-3219507__340.jpg", "Rebecca Moore", "20 January, 2019", "$ 972.00"))
        }

        val yesterdaysTransaction = ArrayList<Transaction>().apply {
            add(Transaction(profileImage = "https://cdn.pixabay.com/photo/2015/09/02/13/24/girl-919048__340.jpg", "Rebecca Moore", "05 August, 2020", "$ 256.00"))
            add(Transaction(profileImage = "https://cdn.pixabay.com/photo/2018/01/15/07/52/woman-3083390__340.jpg", "Rebecca Moore", "14 January, 2022", "$ 1012.00"))
            add(Transaction(profileImage = "https://cdn.pixabay.com/photo/2015/03/03/20/42/man-657869__340.jpg", "Rebecca Moore", "08 March, 2026", "$ 50.00"))
        }

        return ArrayList<TransactionDue>().apply {
            add(TransactionDue("Today", todaysTransaction))
            add(TransactionDue("Yesterday", yesterdaysTransaction))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}