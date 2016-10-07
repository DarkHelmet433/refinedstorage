package refinedstorage.api.util;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * An item stack list.
 */
public interface IItemStackList {
    /**
     * Adds a stack to the list, will merge it with another stack if it already exists in the list.
     *
     * @param stack the stack
     */
    void add(ItemStack stack);

    /**
     * Decrements the count of that stack in the list.
     *
     * @param stack               the stack
     * @param removeIfReachedZero true to remove the stack if the count reaches 0, false otherwise
     * @return whether the remove was successful
     */
    boolean remove(@Nonnull ItemStack stack, boolean removeIfReachedZero);

    /**
     * Returns a stack.
     *
     * @param stack the stack to search for
     * @param flags the flags to compare on, see {@link refinedstorage.api.storage.CompareUtils}
     * @return the stack, or null if no stack was found
     */
    @Nullable
    ItemStack get(@Nonnull ItemStack stack, int flags);

    /**
     * Returns a stack.
     *
     * @param hash the hash of the stack to search for, see {@link refinedstorage.api.network.NetworkUtils#getItemStackHashCode(ItemStack)}
     * @return the stack, or null if no stack was found
     */
    @Nullable
    ItemStack get(int hash);

    /**
     * Clears the list.
     */
    void clear();

    /**
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * @return a collection of stacks in this list
     */
    @Nonnull
    Collection<ItemStack> getStacks();

    /**
     * @return a new copy of this list, with the stacks in it copied as well
     */
    @Nonnull
    IItemStackList copy();
}
