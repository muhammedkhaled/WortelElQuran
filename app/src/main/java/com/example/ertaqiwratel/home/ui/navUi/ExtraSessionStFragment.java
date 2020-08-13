package com.example.ertaqiwratel.home.ui.navUi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.home.adapters.ExtraSessionAdapter;
import com.example.ertaqiwratel.home.adapters.StExtraSessionAdapter;
import com.example.ertaqiwratel.databinding.FragmentExtraSessionStBinding;
import com.example.ertaqiwratel.home.pojo.AvailableChiekhModel;
import com.example.ertaqiwratel.utils.OnItemClickListener;
import com.example.ertaqiwratel.utils.Prevalent;

import java.util.ArrayList;
import java.util.List;

public class ExtraSessionStFragment extends Fragment implements OnItemClickListener {

    private FragmentExtraSessionStBinding binding;
    private List<AvailableChiekhModel> userModelList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExtraSessionStBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (Prevalent.CURRENT_ONLINE_USER.getUserType() != null) {
            if (Prevalent.CURRENT_ONLINE_USER.getUserType().equals("معلم")) {
                setShiehkRecyclerView();
            } else {
                setStudentRecyclerView();
            }
        }
    }


    private void setShiehkRecyclerView() {
        initDataSH();
        ExtraSessionAdapter adapter = new ExtraSessionAdapter(userModelList, this);
        binding.extraRv.setAdapter(adapter);
    }

    private void setStudentRecyclerView() {
        initDataST();
        StExtraSessionAdapter adapter = new StExtraSessionAdapter(userModelList);
        binding.extraRv.setAdapter(adapter);
    }

    private void initDataSH() {

        AvailableChiekhModel model1 = new AvailableChiekhModel();
        model1.setName("الطالب/ محمد خالد");
        model1.setIgaza("الفرقه الثالثه");
        userModelList.add(model1);

        AvailableChiekhModel model = new AvailableChiekhModel();
        model.setName("الطالب/ محمد خالد");
        model1.setIgaza("الفرقه الثالثه");
        userModelList.add(model);

        model.setName("الطالب/ محمد خالد");
        model1.setIgaza("الفرقه الثالثه");
        userModelList.add(model);

        model.setName("الطالب/ محمد خالد");
        model1.setIgaza("الفرقه الثالثه");
        model.setRequestState("");
        userModelList.add(model);

        model.setName("الطالب/ محمد خالد");
        model1.setIgaza("الفرقه الثالثه");
        userModelList.add(model);

    }

    private void initDataST() {

        AvailableChiekhModel model1 = new AvailableChiekhModel();
        model1.setName("الشيخ/ محمد خالد");
        model1.setIgaza("حفص عن عاصم");
        model1.setRequestState("تم القبول");
        userModelList.add(model1);

        AvailableChiekhModel model = new AvailableChiekhModel();
        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        userModelList.add(model);

        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        userModelList.add(model);

        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        userModelList.add(model);

        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        userModelList.add(model);


    }

    @Override
    public void onItemClicked(View view, int position) {
        switch (view.getId()) {
            case R.id.extra_chiekh_img:
                ExtraSessionStFragmentDirections.ActionNavExtraToStudentFragment action =
                        ExtraSessionStFragmentDirections.actionNavExtraToStudentFragment(userModelList.get(position).getName());
                Navigation.findNavController(view).navigate(action);
                break;
            case R.id.extra_accept:

                Toast.makeText(requireContext(), "تم القبول", Toast.LENGTH_SHORT).show();
                break;
            case R.id.extra_reject:

                Toast.makeText(requireContext(), "تم الرفض", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}