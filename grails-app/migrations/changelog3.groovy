databaseChangeLog = {

	changeSet(author: "userpc (generated)", id: "1428097462840-1") {
		modifyDataType(columnName: "num_invitations", newDataType: "bigint", tableName: "partner")
	}

	changeSet(author: "userpc (generated)", id: "1428097462840-2") {
		addNotNullConstraint(columnDataType: "bigint", columnName: "num_invitations", tableName: "partner")
	}
}
