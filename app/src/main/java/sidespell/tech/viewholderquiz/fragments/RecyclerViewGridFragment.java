package sidespell.tech.viewholderquiz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.adapters.RecyclerViewAdapter;
import sidespell.tech.viewholderquiz.controllers.MoviesController;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewGridFragment extends Fragment {

    private MoviesController mController;

    public static RecyclerViewGridFragment newInstance() {
        return new RecyclerViewGridFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mController = new MoviesController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view_grid, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Find all the views
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerGridView);
        TextView tvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // Setup the grid layout manager
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(glm);
        recyclerView.setHasFixedSize(true);

        // Create the adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),
                R.layout.recycler_grid_item, mController.getMovies());

        // Set the adapter
        recyclerView.setAdapter(adapter);

        if (adapter.getItemCount() == 0) {
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            tvEmpty.setVisibility(View.GONE);
        }
    }
}
