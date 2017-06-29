package me.saket.dank.ui.submission;

import com.google.auto.value.AutoValue;

import net.dean.jraw.models.CommentNode;

/**
 * Represents a comment received from remote.
 */
@AutoValue
public abstract class DankCommentNode implements SubmissionCommentRow {

  @Override
  public abstract String fullName();

  public abstract CommentNode commentNode();

  public abstract boolean isCollapsed();

  @Override
  public SubmissionCommentRow.Type type() {
    return Type.USER_COMMENT;
  }

  public static DankCommentNode create(CommentNode commentNode, boolean isCollapsed) {
    String fullName = commentNode.getComment().getFullName();
    return new AutoValue_DankCommentNode(fullName, commentNode, isCollapsed);
  }
}
