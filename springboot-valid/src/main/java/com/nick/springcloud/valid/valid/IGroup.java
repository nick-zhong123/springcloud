package com.nick.springcloud.valid.valid;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @author nick
 * @date 2020/6/26 9:04 PM
 * @package com.nick.springcloud.valid.valid
 * @description
 */
@GroupSequence({Default.class, IGroupA.class, IGroupB.class})
public interface IGroup {
}
