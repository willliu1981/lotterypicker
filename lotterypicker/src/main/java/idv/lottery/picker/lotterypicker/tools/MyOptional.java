package idv.lottery.picker.lotterypicker.tools;

import java.util.Optional;
import java.util.function.Consumer;

public class MyOptional<T> {
	Optional<T> opt;

	public MyOptional(Optional<T> opt) {
		super();
		this.opt = opt;
	}

	public void ifPresentOrElse(Consumer<? super T> action,
			Runnable emptyAction) {

		if (opt.isPresent()) {
			if (action != null) {
				action.accept(opt.get());
			}
		} else {
			if (emptyAction != null) {
				emptyAction.run();
			}
		}

	}

	public T get() {
		return opt.get();
	}
}
