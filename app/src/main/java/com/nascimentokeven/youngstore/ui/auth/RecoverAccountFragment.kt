package com.example.loginyoungstore.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.nascimentokeven.youngstore.R
import com.nascimentokeven.youngstore.databinding.FragmentRecoverAccountBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        initClicks()
    }

    private fun initClicks() {

        binding.btnRecover.setOnClickListener {
            validateData()
        }

    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()

        if(email.isNotEmpty()){
                recoverAccountUser(email)
                binding.progressBar.isVisible = true

        } else {
            Toast.makeText(requireContext(), "Informe o email!", Toast.LENGTH_SHORT).show()

        }
    }

    private fun recoverAccountUser(email: String){
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(requireContext(), "Verifique sua caixa de email", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_recoverAccountFragment_to_loginFragment)
                }
                else {
                    binding.progressBar.isVisible = false
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
