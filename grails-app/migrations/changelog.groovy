databaseChangeLog = {

	changeSet(author: "userpc (generated)", id: "1417887305152-1") {
		createTable(tableName: "card") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cardPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "member_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "integer") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-2") {
		createTable(tableName: "event") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "eventPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "member_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "observation", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "viewed", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "writer", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-3") {
		createTable(tableName: "genetic") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "geneticPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-4") {
		createTable(tableName: "genetic_orders") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "genetic_orderPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "genetic_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "partner_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-5") {
		createTable(tableName: "genetic_type") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "genetic_typePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "color", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "grams", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-6") {
		createTable(tableName: "partner") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "partnerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "varchar(255)")

			column(name: "code", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "date_renovation", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)")

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "firstname", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "friend_id", type: "bigint")

			column(name: "identification_number", type: "varchar(255)")

			column(name: "image", type: "varchar(255)")

			column(name: "lastname", type: "varchar(255)")

			column(name: "password", type: "varchar(255)")

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "signature", type: "varchar(255)")

			column(name: "status", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-7") {
		createTable(tableName: "partner_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "partner_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-8") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-9") {
		addPrimaryKey(columnNames: "role_id, partner_id", constraintName: "partner_rolePK", tableName: "partner_role")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-18") {
		createIndex(indexName: "FK2E7B109D428C71", tableName: "card") {
			column(name: "member_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-19") {
		createIndex(indexName: "FK5C6729A9D428C71", tableName: "event") {
			column(name: "member_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-20") {
		createIndex(indexName: "FKFB3911598A201ABC", tableName: "genetic") {
			column(name: "type_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-21") {
		createIndex(indexName: "FK1939C88B5763E383", tableName: "genetic_orders") {
			column(name: "partner_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-22") {
		createIndex(indexName: "FK1939C88B8DC94DE3", tableName: "genetic_orders") {
			column(name: "genetic_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-23") {
		createIndex(indexName: "FKD0BCDCC87D0DDED", tableName: "partner") {
			column(name: "friend_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-24") {
		createIndex(indexName: "FK9A6198D32DFABD1", tableName: "partner_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-25") {
		createIndex(indexName: "FK9A6198D5763E383", tableName: "partner_role") {
			column(name: "partner_id")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-26") {
		createIndex(indexName: "authority_uniq_1417887305094", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-10") {
		addForeignKeyConstraint(baseColumnNames: "member_id", baseTableName: "card", constraintName: "FK2E7B109D428C71", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-11") {
		addForeignKeyConstraint(baseColumnNames: "member_id", baseTableName: "event", constraintName: "FK5C6729A9D428C71", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-12") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "genetic", constraintName: "FKFB3911598A201ABC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genetic_type", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-13") {
		addForeignKeyConstraint(baseColumnNames: "genetic_id", baseTableName: "genetic_orders", constraintName: "FK1939C88B8DC94DE3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genetic", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-14") {
		addForeignKeyConstraint(baseColumnNames: "partner_id", baseTableName: "genetic_orders", constraintName: "FK1939C88B5763E383", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-15") {
		addForeignKeyConstraint(baseColumnNames: "friend_id", baseTableName: "partner", constraintName: "FKD0BCDCC87D0DDED", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-16") {
		addForeignKeyConstraint(baseColumnNames: "partner_id", baseTableName: "partner_role", constraintName: "FK9A6198D5763E383", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "partner", referencesUniqueColumn: "false")
	}

	changeSet(author: "userpc (generated)", id: "1417887305152-17") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "partner_role", constraintName: "FK9A6198D32DFABD1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}
}
