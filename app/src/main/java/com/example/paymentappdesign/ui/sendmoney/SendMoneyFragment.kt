package com.example.paymentappdesign.ui.sendmoney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.CreditCard
import com.example.paymentappdesign.data.Recipient
import com.example.paymentappdesign.databinding.FragmentSendMoneyBinding
import com.example.paymentappdesign.databinding.FragmentSentMoneyBinding
import com.example.paymentappdesign.ui.sentmoney.CreditCardAdapter
import com.example.paymentappdesign.ui.sentmoney.TransactionDueAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SendMoneyFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSendMoneyBinding? = null
    private val binding get() = _binding!!

    private val creditCardAdapter by lazy {
        CreditCardSelectionAdapter()
    }

    private val recipientAdapter by lazy {
        RecipientAdapter()
    }

    private fun itemClick(position: Int) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSendMoneyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
        initRecyclerView()
        initListeners()
    }

    private fun initTabLayout() {
        binding.tblSendMoney.addTab(
            binding.tblSendMoney.newTab().setText(R.string.card)
        )
        binding.tblSendMoney.addTab(
            binding.tblSendMoney.newTab().setText(R.string.bank)
        )
    }

    private fun initRecyclerView() {
        binding.rvCreditCards.adapter = creditCardAdapter
        creditCardAdapter.setItems(getCreditCards(), true)
        binding.rvCreditCards.scrollToPosition(2)

        binding.rvRecipients.adapter = recipientAdapter
        recipientAdapter.setItems(getRecipients(), true)
        binding.rvRecipients.scrollToPosition(2)
    }

    private fun initListeners() {
      with(binding){
          tvChangeCurrency.setOnClickListener(this@SendMoneyFragment)
      }
    }

    private fun getRecipients(): ArrayList<Recipient> {
        return ArrayList<Recipient>().apply {
            add(
                Recipient(
                    "https://cdn.pixabay.com/photo/2015/09/02/13/24/girl-919048__340.jpg",
                    "Milan Vadhel"
                )
            )
            add(
                Recipient(
                    "https://cdn.pixabay.com/photo/2018/01/15/07/52/woman-3083390__340.jpg",
                    "Milan Vadhel"
                )
            )
            add(
                Recipient(
                    "https://cdn.pixabay.com/photo/2015/03/03/20/42/man-657869__340.jpg",
                    "Milan Vadhel",
                    isSelected = true
                )
            )
            add(
                Recipient(
                    "https://cdn.pixabay.com/photo/2018/03/12/12/32/woman-3219507__340.jpg",
                    "Milan Vadhel"
                )
            )
            add(
                Recipient(
                    "https://cdn.pixabay.com/photo/2018/03/12/12/32/woman-3219507__340.jpg",
                    "Milan Vadhel"
                )
            )
        }
    }

    private fun getCreditCards(): ArrayList<CreditCard> {
        return ArrayList<CreditCard>().apply {
            add(CreditCard(cardNumber = "**** 3849", cardBalance = "$ 1,345.56"))
            add(CreditCard(cardNumber = "**** 2020", cardBalance = "$ 1,345.56"))
            add(CreditCard(cardNumber = "**** 5684", cardBalance = "$ 1,345.56",isSelected = true))
            add(CreditCard(cardNumber = "**** 2345", cardBalance = "$ 1,345.56"))
            add(CreditCard(cardNumber = "**** 7845", cardBalance = "$ 1,345.56"))
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){

        }
    }
}